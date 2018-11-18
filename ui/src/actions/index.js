import { 
    GET_FILES, GET_LINES, ANALYZE_TEXT, 
    CLEAR_USER_STATISTICS, startActionWithType, 
    successActionWithType, failActionWithType
} from 'constants/actionTypes'
import * as endpoints from 'constants/routes/api'
import axiosInstance from 'constants/axiosInstance'

export const getFilesRequest = () => (dispatch) => {
    dispatch(startActionWithType(GET_FILES));
    axiosInstance.get(endpoints.allFiles)
        .then(response => {
            dispatch(successActionWithType(GET_FILES, response.data));
        })
        .catch(err => {
            dispatch(failActionWithType(GET_FILES, err));
        })
} 

export const getLinesRequest = (fileId) => (dispatch) => {
    dispatch(startActionWithType(GET_LINES));
    axiosInstance.get(endpoints.linesByFileId(fileId))
        .then(response => {
            dispatch(successActionWithType(GET_LINES, response.data));
        })
        .catch(err => {
            dispatch(failActionWithType(GET_LINES, err));
        })
} 

export const analyzeTextRequest = (text) => (dispatch) => {
    dispatch(startActionWithType(ANALYZE_TEXT));
    axiosInstance.post(endpoints.analyzeText, {content : text})
        .then(response => {
            dispatch(successActionWithType(ANALYZE_TEXT, response.data));
        })
        .catch(err => {
            dispatch(failActionWithType(ANALYZE_TEXT, err));
        })
}

export const clearUserStatistics = () => ({
    type: CLEAR_USER_STATISTICS
})
