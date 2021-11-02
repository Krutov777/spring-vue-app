import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router";
import ElectronicPage from "@/pages/ElectronicPage";
import About from "@/pages/About";
import Login from "@/pages/Login";

const routes = [
    {
        path: '/',
        component: Main
    },
    {
        path: '/electronics',
        component: ElectronicPage
    },
    {
        path: '/about',
        component: About
    },
    {
        path: '/login',
        component: Login
    }

]

const router = createRouter( {
    routes,
    history: createWebHistory(process.env.BASE_URL)
})

export  default router;