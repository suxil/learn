// import WorkLogList from './containers/WorkLog/WorkLogList';
//
// let routerConfig = {
//     '/' : {
//         exact: true,
//         title: '工作日志',
//         component: WorkLogList
//     },
// };
//
// function RouterConfig({routerConfig}) {
//     return {
//         get: () => {
//             return routerConfig;
//         },
//         linkInit: (callback) => {
//             if (typeof callback === 'function') {
//                 const links = [];
//                 Object.keys(routerConfig).forEach(path => {
//                     links.push(callback(path, routerConfig[path]));
//                 });
//                 return links;
//             }
//             throw new Error("参数必须是函数");
//         },
//         routerInit: (callback) => {
//             if (typeof callback === 'function') {
//                 const routers = [];
//                 Object.keys(routerConfig).forEach(path => {
//                     routers.push(callback(path, routerConfig[path]));
//                 });
//                 return routers;
//             }
//             throw new Error("参数必须是函数");
//         }
//     };
// }
//
// export {
//     RouterConfig,
//     routerConfig
// };

import React from 'react';
import PropTypes from 'prop-types';
import {Route, routerRedux, Switch} from 'dva/router';
import {LocaleProvider} from 'antd';
import 'antd/dist/antd.less';
import zhCN from 'antd/lib/locale-provider/zh_CN';

const {ConnectedRouter} = routerRedux;

import WorkLog from './routes/WorkLog/WorkLog';

function RouterConfig({history, app}) {
    return (
        <LocaleProvider locale={zhCN}>
            <ConnectedRouter history={history}>
                <Switch>
                    {/*<Route path='/' exact component={BasicLayout}/>*/}
                    <Route path='/' exact component={WorkLog}/>
                </Switch>
            </ConnectedRouter>
        </LocaleProvider>
    );
}

RouterConfig.propTypes = {
    history: PropTypes.object,
    app: PropTypes.object,
};

export default RouterConfig;