// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  ssr: false,
  srcDir: 'src',
  css: ['~/assets/main.scss', '~/assets/variables.scss'],
  plugins: [
    '~/plugins/vuetify'
  ],
  devtools: { enabled: true }
})
