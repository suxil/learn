import {
    worklogSearch
} from '../services/worklog';

export default {
    namespace: 'worklog',
    state: {
        page: {
            data: [],
            total: 0,
            size: 10,
            page: 0,
        }
    },
    effects: {
        * search(_, {call, put}) {
            const data = yield call(worklogSearch);
            yield put({type: 'worklog/searchSuccess', ...data.content});
        },
        * delete(_, {call, put}) {
            const data = yield call(worklogSearch);
            yield put({type: 'worklog/deleteSuccess', ...data.content});
        }
    },
    reducers: {
        searchSuccess(state, action) {
            return {
                ...state,
                page: {...action.data}
            };
        },
        deleteSuccess(state, { payload: id }) {
            return {
                ...state,
            };
        },
    },
    subscriptions: {

    }
};
