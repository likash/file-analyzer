export const GET_FILES = "GET_FILES";
export const GET_LINES = "GET_LINES";
export const ANALYZE_TEXT = "ANALYZE_TEXT";
export const CLEAR_USER_STATISTICS = "CLEAR_USER_STATISTICS";

export const start = (type) => `START__${type}`;
export const success = (type) => `SUCCESS__${type}`;
export const fail = (type) => `FAIL__${type}`;

export const startActionWithType = (type, payload) => ({
    type : start(type),
    payload
}); 

export const successActionWithType = (type, payload) => ({
    type : success(type),
    payload
}); 

export const failActionWithType = (type, payload) => ({
    type : fail(type),
    payload
}); 
