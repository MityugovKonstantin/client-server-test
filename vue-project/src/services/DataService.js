import http from "../http-common";

class DataService {
  getAll() {
    return http.get();
  }

  getOne(id) {
    return http.get(`/${id}`);
  }

  create(data) {
    http.post(`/create`, data);
  }

  update (data, id) {
    http.patch(`/update/${id}`, data);
  }

  delete(id) {
    http.delete(`/delete/${id}`);
  }
}

export default new DataService();