import { createStore } from 'vuex';

const store = createStore({
    state: {
        count: 0,
        baseURL: 'http://localhost:8088'
    },
    mutations: {
        increment(state) {
            state.count++;
        }
    },
    actions: {
        increment({ commit }) {
            commit('increment');
        }
    },
    getters: {
        doubleCount: state => state.count * 2
    },

});

export default store;
