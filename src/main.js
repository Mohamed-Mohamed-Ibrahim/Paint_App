import { createApp } from 'vue';
import App from './App.vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Konva from 'konva';

const app = createApp(App);

// Attach Konva to global properties
app.config.globalProperties.$konva = Konva;

app.mount('#app');
