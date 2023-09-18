<script lang="ts" setup>
const onSubmit = (): void => {}
</script>

<template>
  <v-container>
    <atoms-app-logo-with-title :width="300" class="mx-auto py-8" />

    <v-card width="80%" class="mx-auto mt-5">
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
  </v-container>
</template>
