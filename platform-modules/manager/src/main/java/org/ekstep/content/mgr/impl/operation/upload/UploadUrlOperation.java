package org.ekstep.content.mgr.impl.operation.upload;
import org.ekstep.common.Platform;
import org.apache.commons.lang3.StringUtils;
import org.ekstep.common.dto.Response;
import org.ekstep.common.enums.TaxonomyErrorCodes;
import org.ekstep.common.exception.ClientException;
import org.ekstep.common.exception.ResponseCode;
import org.ekstep.common.exception.ServerException;
import org.ekstep.content.mimetype.mgr.IMimeTypeManager;
import org.ekstep.graph.dac.model.Node;
import org.ekstep.telemetry.logger.TelemetryManager;

public class UploadUrlOperation extends BaseUploadOperation {

    public Response upload(String contentId, String fileUrl, String mimeType) {
        boolean updateMimeType = false;
        try {
        String storageKey = Platform.config.getString("azure_storage_key");
		String storageSecret = Platform.config.getString("azure_storage_secret");
        String cloud_storage_type = Platform.config.getString("cloud_storage_type");
		String aws_storage_secret = Platform.config.getString("aws_storage_secret");
        String aws_storage_key = Platform.config.getString("aws_storage_key");
		String aws_storage_container = Platform.config.getString("aws_storage_container");
        System.out.println("[BaseContentManager] getNodeForOperation calling linenumber 350 : ");
        System.out.println("[BaseContentManager] AZURE storageKey : "+storageKey);
		System.out.println("[BaseContentManager] AZURE storageSecret : "+storageSecret);
            System.out.println("[UploadUrlOperation] Upload calling line number 18 : ");
            validateEmptyOrNullContentId(contentId);
            System.out.println("[UploadUrlOperation] Upload calling line number 20 : ");

            validateEmptyOrNullFileUrl(fileUrl);
            System.out.println("[UploadUrlOperation] Upload calling line number 23 : ");

            isImageContentId(contentId);
            System.out.println("[UploadUrlOperation] Upload calling line number 26 : ");

            Node node = getNodeForOperation(contentId, "upload");
            System.out.println("[UploadUrlOperation] Upload calling line number 29 : ");

            isNodeUnderProcessing(node, "Upload");
            System.out.println("[UploadUrlOperation] Upload calling line number 32 : ");
            if (StringUtils.isBlank(mimeType)) {
                mimeType = getMimeType(node);
            } else {
                setMimeTypeForUpload(mimeType, node);
                updateMimeType = true;
            }

            validateUrlLicense(mimeType, fileUrl, node);
            System.out.println("[UploadUrlOperation] Upload calling line number 41 : ");

            TelemetryManager.log("Mime-Type: " + mimeType + " | [Content ID: " + contentId + "]");
            IMimeTypeManager mimeTypeManager = getMimeTypeManger(contentId, mimeType, node);

            Response res = mimeTypeManager.upload(contentId, node, fileUrl);
            System.out.println("[UploadUrlOperation] Upload calling line number 47 : ");
            Response response = validateResponseAndUpdateMimeType(updateMimeType, node, res, contentId, mimeType);
            if (null != response && checkError(response)) { return response; }

            return checkAndReturnUploadResponse(res);
        } catch (ClientException e) {
            throw e;
        } catch (ServerException e) {
            return ERROR(e.getErrCode(), e.getMessage(), ResponseCode.SERVER_ERROR);
        } catch (Exception e) {
            System.out.println("[UploadUrlOperation] Upload exception : ");
            e.printStackTrace();
            String message = "Something went wrong while processing uploaded file.";
            TelemetryManager.error(message, e);
            return ERROR(TaxonomyErrorCodes.SYSTEM_ERROR.name(), message, ResponseCode.SERVER_ERROR);
        }
    }

    private void validateUrlLicense(String mimeType, String fileUrl, Node node) {
        switch (mimeType) {
            case "video/x-youtube": checkYoutubeLicense(fileUrl, node);
                                    break;
            default:                break;
        }
    }

}
