import { createWebHistory, createRouter } from "vue-router";

const mainRoutes = [
    {
        path: '/',
        name: 'main',
        component: () => import('./components/Main.vue')
    }
];

const booksRoutes = [
    {
        path: '/books',
        name: 'books',
        component: () => import('./components/books/Books.vue')
    },
    {
        path: "/book",
        name: "book",
        component: () => import("./components/books/Book.vue")
    }
];

const peopleRoutes = [
    {
        path: '/people',
        name: 'people',
        component: () => import('./components/people/People.vue')
    },
    {
        path: "/person",
        name: "person",
        component: () => import("./components/people/Person.vue")
    }
];

const routes = [].concat(mainRoutes, booksRoutes, peopleRoutes);

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;