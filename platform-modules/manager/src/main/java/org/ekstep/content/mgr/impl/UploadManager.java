package org.ekstep.content.mgr.impl;

import org.ekstep.common.dto.Response;
import org.ekstep.content.mgr.impl.operation.upload.UploadFileOperation;
import org.ekstep.content.mgr.impl.operation.upload.UploadUrlOperation;

import java.io.File;

public class UploadManager {

    private final UploadFileOperation uploadFileOperation = new UploadFileOperation();
    private final UploadUrlOperation uploadUrlOperation = new UploadUrlOperation();

    public Response upload(String contentId, File uploadedFile, String mimeType) {
        System.out.println("[UploadManager] upload calling : "+contentId);
        return this.uploadFileOperation.upload(contentId, uploadedFile, mimeType);
    }

    public Response upload(String contentId, String fileUrl, String mimeType) {
        System.out.println("[UploadManager] upload calling : "+contentId);
        return this.uploadUrlOperation.upload(contentId, fileUrl, mimeType);
    }

}