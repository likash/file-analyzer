import { GET_FILES, start, success, fail } from "constants/actionTypes"

const initialState = [
    {
        id: 1,
        name: 'lol.txt',
        location: 'C://ocation',
        longestWord: 'Hello',
        shortestWord: 'hi',
        averageWordLength: 3,
        length: 1000,
    },
    {
        id: 2,
        name: 'losdasdsdafl.txt',
        location: 'C://ocasdgfasdfasdation',
        longestWord: 'Hello',
        shortestWord: 'hi',
        averageWordLength: 3,
        length: 1000,
    }
];

export default (state = initialState, action) => {
    switch (action.type) {
        case (success(GET_FILES)) :
            return action.payload;            
        default: return state;
    }
}