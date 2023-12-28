import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import svgLoader from 'vite-svg-loader'
import eslint from 'vite-plugin-eslint'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        eslint(),
        svgLoader({
            defaultImport: 'component'
        })
    ],
})
