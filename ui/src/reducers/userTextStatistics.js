import { ANALYZE_TEXT, CLEAR_USER_STATISTICS, start, success, fail } from "constants/actionTypes"

const initialState = null;

export default(state = initialState, action) => {
    switch (action.type) {
        case (success(ANALYZE_TEXT)) :
            return action.payload;
        case (CLEAR_USER_STATISTICS) :
            return initialState;
        default: return state;
    }
}

