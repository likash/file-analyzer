import { GET_LINES, start, success, fail } from "constants/actionTypes"

const initialState = [];

export default (state = initialState, action) => {
    switch (action.type) {
        case (success(GET_LINES)) :
            return action.payload;            
        default: return state;
    }
}