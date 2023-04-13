import axios from 'axios';

export default {

    /**
     * 
     * @returns a promise that resolves to collection of movies
     */
    getAll() {
        return axios.get('/movies')
            .then(resp => resp.data);
    },

    /**
     * 
     * @param {number} id - the id of the movie to fetch 
     * @returns - a promise that resolves to a movie 
     *              or null if the move was not found
     */
    getById(id) {
        return axios.get(`/movies/${id}`)
            .then(resp => resp.data);
    }

}