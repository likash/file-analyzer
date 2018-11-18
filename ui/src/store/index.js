import { applyMiddleware, compose, createStore } from 'redux'
import { routerMiddleware } from 'connected-react-router'
import createRootReducer from 'reducers'
import thunk from 'redux-thunk';


export default function configureStore (history) {

  const enhancers = [

  ]

  const middleware = [
      routerMiddleware(history),
      thunk
  ]

  const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose

  const composedEnhancers = composeEnhancers(
      applyMiddleware(...middleware),
      ...enhancers
  )

  const store = createStore(
      createRootReducer(history),
      composedEnhancers
  )

  return store
}