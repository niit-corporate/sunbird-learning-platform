package org.ekstep.graph.dac.exception;

public enum GraphDACErrorCodes {
    
    ERR_GRAPH_INVALID_OPERATION,

    ERR_DAC_SYS_EXCEPTION,

    ERR_GRAPH_INVALID_GRAPH_ID,

    ERR_GRAPH_ALREADY_EXISTS,

    ERR_GRAPH_NOT_FOUND,
    
    ERR_GRAPH_DELETE_UNKNOWN_ERROR,

    ERR_GRAPH_NODE_NOT_FOUND,

    ERR_GRAPH_INVALID_NODE_ID,
    
    ERR_GRAPH_NULL_DB_NODE,
    
    ERR_GRAPH_NULL_DB_REL,
    
    ERR_CREATE_UNIQUE_CONSTRAINT_MISSING_REQ_PARAMS,
    
    ERR_CREATE_INDEX_MISSING_REQ_PARAMS,

    ERR_CREATE_RELATION_MISSING_REQ_PARAMS,

    ERR_DELETE_RELATION_MISSING_REQ_PARAMS,

    ERR_UPDATE_RELATION_MISSING_REQ_PARAMS,

    ERR_CREATE_NODE_MISSING_REQ_PARAMS,
    
    ERR_IMPORT_NODE_MISSING_REQ_PARAMS,

    ERR_UPDATE_NODE_MISSING_REQ_PARAMS,

    ERR_DELETE_NODE_MISSING_REQ_PARAMS,
    
    ERR_GET_NODE_MISSING_REQ_PARAMS,
    
    ERR_GET_NODE_PROPERTY_MISSING_REQ_PARAMS,
    
    ERR_GET_NODE_LIST_MISSING_REQ_PARAMS,
    
    ERR_GET_RELATIONS_MISSING_REQ_PARAMS,
    
    ERR_CHECK_LOOP_MISSING_REQ_PARAMS,
    
    ERR_CREATE_COLLECTION_MISSING_REQ_PARAMS,
    
    ERR_DELETE_COLLECTION_MISSING_REQ_PARAMS,
    
    ERR_SEARCH_NODES_MISSING_REQ_PARAMS,
    
    ERR_TRAVERSAL_MISSING_REQ_PARAMS,
    
    ERR_UPDATE_NODE_INVALID_NODE_TYPE,
    
    ERR_UPDATE_NODE_INVALID_OBJECT_TYPE,
    
    ERR_GRAPH_QUERY_NOT_FOUND,
    
    ERR_GRAPH_QUERY_KEY_NOT_FOUND;
}
