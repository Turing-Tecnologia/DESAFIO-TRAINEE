import { http } from './config'

export default {
    listar: () => {
        return http.get('/listar/tarefas')
    },

    salvar: (tarefa) => {
        return http.post('/salvar/tarefa', tarefa)
    },

    atualizar: (tarefa) => {
        return http.put('/atualiza/tarefa', tarefa)
    },

    apagar: (tarefa) => {
        return http.delete('/excluir/tarefa', { data: tarefa })
    }
}