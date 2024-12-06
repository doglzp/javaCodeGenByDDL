import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// 创建应用
const app = createApp(App)

app.use(ElementPlus)
// 挂载应用
app.mount('#app')
