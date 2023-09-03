<script>
  import BookWindow from './components/BookWindow.vue'
  import DataService from './services/DataService.js'

  export default {
  components: { BookWindow },
    data() {
      return {
        books: [],
        book: {
          id: null,
          name: null,
          author: null
        },
        pressedId: 1
      }
    },
    methods: {
      getAll() {
        DataService.getAll().then(response => this.books = response.data);
      }, 

      showBook(id) {
        this.pressedId = id;
        console.log(id);
      }
    },
    mounted() {
      this.getAll();
    }
  }
</script>

<template>
  <div class="flex-container">
    <ul class="list" v-if="books.length != 0">
      <li class="field" v-for="book in books" :key="book.id">
        <a @click="showBook(book.id)" href="#background-blackout">{{ book.author + ', ' + book.name }}</a>
      </li>
    </ul>
  </div>
  <BookWindow book-id="pressedId"></BookWindow>
</template>

<style>
  .flex-container {
    display: flex;
    flex-direction: column;
    color: white;
  }
</style>