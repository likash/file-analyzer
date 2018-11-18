import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import { Provider } from 'react-redux';
import configureStore from 'store';
import history from './history';
import { ConnectedRouter } from 'connected-react-router';
import { Route, Switch, Redirect } from 'react-router-dom';
import TextAnalyzerPage from 'containers/TextAnalyzerPage';
import LinesListPage from 'containers/LinesListPage';
import * as routes from 'constants/routes/ui';

const store = configureStore(history)

ReactDOM.render(
    <Provider store={store}>
        <ConnectedRouter history={history}>
            <Switch>              
                <Route path={routes.fileLines} component={LinesListPage}/>
                <Route path={routes.analyzeText} component={TextAnalyzerPage}/>
                <Route path={routes.files} component={App} />
                <Redirect to={routes.files} />
            </Switch>
        </ConnectedRouter>       
    </Provider>,
    document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
