import { combineReducers } from 'redux'
import { connectRouter } from 'connected-react-router'
import files from 'reducers/files'
import lines from 'reducers/lines'
import userTextStatistics from 'reducers/userTextStatistics'

export default (history) => combineReducers({
  router: connectRouter(history),
  files,
  lines,
  userTextStatistics
})