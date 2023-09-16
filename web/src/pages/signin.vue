<script lang="ts" setup>
const onSubmit = (): void => {}
</script>

<template>
  <v-card>
    <v-card-title>ログイン</v-card-title>

    <v-form @submit.prevent="onSubmit">
      <img class="logo" alt="ふるマル ロゴ" src="/app-logo-with-title.svg" :width="450" >
      <v-card-text>
        <v-text-field required label="ユーザーID（メールアドレス)" type="email" />
        <v-text-field required label="パスワード" />
      </v-card-text>
      <v-card-actions>
        <v-btn type="submit" block color="primary" variant="outlined"> ログイン </v-btn>
      </v-card-actions>
    </v-form>
  </v-card>
</template>

<style lang="scss" scoped>
.logo {
  height: auto;
  display: block;
  max-width: 80%;
}
</style>
