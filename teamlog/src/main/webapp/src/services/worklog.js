import request from '../utils/request';

export async function worklogSearch(param) {
    return request('http://localhost:18191/api/v1/work-logs', {...param.page});
}