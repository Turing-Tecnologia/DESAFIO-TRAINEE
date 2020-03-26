<template>
  <div id="app">
    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">ToDoList</a>
      </div>
    </nav>
    <div class="container">
      <form @submit.prevent="salvar">
        <label>Titulo</label>
        <input type="text" placeholder="Titulo" v-model="tarefa.titulo" />
        <label>Descrição</label>
        <input type="text" placeholder="Descriçao" v-model="tarefa.descricao" />
        <label>Data</label>
        <input type="text" placeholder="Data (dd/MM/yyyy)" v-model="tarefa.data_conclusao" />
        <label>Situação</label>
        <select v-model="tarefa.status" class="browser-default">
          <option value="EM ABERTO" selected>EM ABERTO</option>
          <option value="CONLUIDO">CONCLUIDO</option>
        </select>
        <br />
        <button class="waves-effect waves-light btn-small">
          Salvar
          <i class="material-icons left">save</i>
        </button>
      </form>
      <table>
        <thead>
          <tr>
            <th>TITULO</th>
            <th>DESCRIÇAO</th>
            <th>DATA</th>
            <th>SITUAÇÃO</th>
            <th>OPÇÕES</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="tarefa of tarefas" :key="tarefa.id">
            <td>{{ tarefa.titulo }}</td>
            <td>{{ tarefa.descricao }}</td>
            <td>{{ tarefa.data_conclusao }}</td>
            <td>{{ tarefa.status }}</td>
            <td>
              <button @click="editar(tarefa)" class="waves-effect btn-small blue darken-1">
                <i class="material-icons">create</i>
              </button>
              <button @click="remover(tarefa)" class="waves-effect btn-small red darken-1">
                <i class="material-icons">delete_sweep</i>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import Tarefa from "./services/tarefa";
export default {
  data() {
    return {
      tarefa: {},
      tarefas: []
    };
  },
  mounted() {
    this.listar();
  },
  methods: {
    listar() {
      Tarefa.listar().then(resposta => {
        this.tarefas = resposta.data;
      });
    },
    salvar() {
      if (!this.tarefa.id) {
        Tarefa.salvar(this.tarefa).then(resposta => {
          alert("Sua tarefa foi salva com sucesso");
          this.listar();
          this.tarefa = {};
        });
      } else {
        Tarefa.atualizar(this.tarefa).then(resposta => {
          alert("Tarefa alterada com sucesso");
          this.listar();
          this.tarefa = {};
        });
      }
    },
    editar(tarefa) {
      this.tarefa = tarefa;
    },
    remover(tarefa) {
      Tarefa.apagar(tarefa)
        .then(resposta => {
          this.listar();
          this.errors = [];
        })
        .catch(e => {
          this.errors = e.response.data.errors;
        });
    }
  }
};
</script>

<style>
</style>
