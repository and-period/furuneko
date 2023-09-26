<script lang="ts" setup>
import { VDataTable } from 'vuetify/lib/labs/components.mjs'
import { mdiImport, mdiExport } from '@mdi/js'
import { Order } from '~/types/props/order'

const headers: VDataTable['headers'] = [
  {
    title: '注文者',
    key: 'userName'
  },
  {
    title: '支払いステータス',
    key: 'payment.status'
  },
  {
    title: '購入金額',
    key: 'payment.total'
  },
  {
    title: '購入日時',
    key: 'orderedAt'
  },
  {
    title: '配送ステータス',
    key: 'fulfillment.status'
  },
  {
    title: '配送方法',
    key: 'fulfillment.shippingMethod'
  },
  {
    title: '伝票番号',
    key: 'payment.paymentId'
  }
]

</script>

<template>
  <div>
    <v-dialog width="500">
      <v-card>
        <v-card-title class="text-h6 primaryLight">
          ファイルの出力
        </v-card-title>

        <v-card-text>
          <v-select
            label="配送会社"
            class="mr-2 ml-2"
            item-title="deliveryCompany"
            item-value="value"
          />
          <v-file-input class="mr-2" label="CSVを選択" />
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn color="error" variant="text">
            キャンセル
          </v-btn>
          <v-btn color="primary" variant="outlined">
            登録
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-card class="mt-4" flat>
      <v-card-title class="d-flex flex-row">
        注文
        <v-spacer />
        <v-btn color="primary" variant="outlined">
          <v-icon start :icon="mdiImport" />
          Import
        </v-btn>
        <v-btn class="ml-4" color="secondary" variant="outlined">
          <v-icon start :icon="mdiExport" />
          Export
        </v-btn>
      </v-card-title>
    </v-card>
  </div>
</template>
