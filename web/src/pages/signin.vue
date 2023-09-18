<script lang="ts" setup>
const onSubmit = (): void => {}
</script>

<template>
  <v-card>
    <v-card-title class="mx-auto pt-8">
      ふるねこログイン
    </v-card-title>
    <v-form @submit.prevent="onSubmit">
      <v-card-text>
        <v-text-field required label="ユーザーID（メールアドレス)" type="email" />
        <v-text-field required label="パスワード" />
      </v-card-text>
      <v-card-actions>
        <v-btn type="submit" rounded block color="primary" variant="outlined"> ログイン </v-btn>
      </v-card-actions>
    </v-form>
  </v-card>
</template>

<style lang="scss" scoped>
</style>
