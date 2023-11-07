import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodosStore = defineStore('todos', () => {
  let id = 0;
  const todos = ref([
    {id: id++, text: '수업듣기', isDone: false},
    {id: id++, text: '점심먹기', isDone: false},
    {id: id++, text: '춤추기', isDone: false}
  ])

  const addTodo = function (text) {
    todos.value.push({id:id++, text:text, isDone:false});
    // {id:id++, text, isDone:false} 이것도 가능
  }

  const deleteTodo = function(id) {
    const idx = todos.value.findIndex((todo)=>todo.id === id);
    todos.value.splice(idx, 1);
  }

  const updateTodo = function(id) {
    todos.value = todos.value.map((todo)=> {
      if(todo.id === id) {
        todo.isDone = !todo.isDone
      }
      return todo
    })
  }

  const doneTodoCount = computed(() => {
    return todos.value.filter((todo) => todo.isDone).length
  })
  return { todos, addTodo, deleteTodo, updateTodo, doneTodoCount }
}, {persist: true})
