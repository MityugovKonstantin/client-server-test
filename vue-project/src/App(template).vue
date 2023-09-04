<script setup>

import { onMounted, ref } from 'vue';

const books = ref([])
const pressedId = ref(1)

async function getAll() {
  try {
    const fetchedBooks = await fetch('http://localhost:8080/test');
    books.value = await fetchedBooks.json();
  } catch (error) {
    console.error(error);
  }
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

</template>

<style>

.flex-container {
  display: flex;
  flex-direction: column;
  color: white;
}

</style>