import dva from 'dva';
import {createLogger} from 'redux-logger';
import createHistory from 'history/createBrowserHistory';
import createLoading from 'dva-loading';
import * as models from './models';

const app = dva({
    onAction: [createLogger()],
    history: createHistory(),
});

app.use(createLoading());

if (models) {
    Object.keys(models).forEach((key) => {
        console.log(models[key]);
        app.model(models[key]);
    });
}

app.router(require('./router').default);

app.start('#root');