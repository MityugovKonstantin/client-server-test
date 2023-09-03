<script setup>

import BookWindow from './components/BookWindow.vue'
import DataService from './services/DataService.js'
import { onMounted, ref } from 'vue';

const books = ref([])
const pressedId = ref(1)

function getAll() {
  DataService.getAll().then(response => books.value = response.data);
}

function showBook(id) {
  this.pressedId = id;
  console.log(id);
}

onMounted(() => getAll());

</script>

<template>

<div class="flex-container">
  <ul class="list" v-if="books.length != 0">
    <li class="field" v-for="book in books" :key="book.id">
      <a @click="showBook(book.id)" href="#background-blackout">{{ book.author + ', ' + book.name }}</a>
    </li>
  </ul>
</div>
<BookWindow :book-id="pressedId.value"></BookWindow>

</template>

<style>

.flex-container {
  display: flex;
  flex-direction: column;
  color: white;
}

</style>