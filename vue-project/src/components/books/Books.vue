<script setup>

import { onMounted, ref } from 'vue';

const books = ref([])

async function getAll() {
  try {
    const fetchedBooks = await fetch('http://localhost:8080/test');
    books.value = await fetchedBooks.json();
  } catch (error) {
    console.error(error);
  }
}

onMounted(() => getAll());

</script>

<template>

<div class="flex-container">
  <ul class="list" v-if="books.length != 0">
    <li class="field" v-for="book in books" :key="book.id">
      <router-link :to="'/book/' + book.id">{{ book.author + ', ' + book.name }}</router-link>
    </li>
  </ul>
</div>

</template>

<style></style>