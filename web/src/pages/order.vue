<script lang="ts" setup>
import { VDataTable } from 'vuetify/lib/labs/components.mjs'
import { Order } from '~/types/props/order'

const props = defineProps({
  loading: {
    type: Boolean,
    default: false
  },
  importDialog: {
    type: Boolean,
    default: false
  },
  exportDialog: {
    type: Boolean,
    default: false
  },
  isAlert: {
    type: Boolean,
    default: false
  },
  alertText: {
    type: String,
    default: ''
  },
  tableItemsPerPage: {
    type: Number,
    default: 20
  },
  tableItemsTotal: {
    type: Number,
    default: 0
  },
  importFormData: {
    type: Object,
    default: () => ({
      company: false
    })
  },
  exportFormData: {
    type: Object,
    default: () => ({
      company: false
    })
  }
})

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
const fulfillmentCompanies: Order[] = [
  { name: '佐川急便', value: '佐川急便' },
  { name: 'ヤマト運輸', value: 'ヤマト運輸' }
]

</script>

<template>
  <v-dialog width="500">
    <v-card>
      <v-card-title class="text-h6 primaryLight">
        ファイルの取り込み
      </v-card-title>

      <v-card-text>
        <v-select
          v-model="importFormDataValue.company"
          label="配送会社"
          class="mr-2 ml-2"
          :items="fulfillmentCompanies"
          item-title="name"
          item-value="value"
        />
        <v-file-input class="mr-2" label="CSVを選択" />
      </v-card-text>
      <v-card-actions>
        <v-spacer />
        <v-btn color="error" variant="text" @click="toggleImportDialog">
          キャンセル
        </v-btn>
        <v-btn color="primary" variant="outlined" :loading="loading" @click="onSubmitImport">
          登録
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>

  <v-dialog v-model="exportDialogValue" width="500">
    <v-card>
      <v-card-title class="text-h6 primaryLight">
        ファイルの出力
      </v-card-title>

      <v-card-text>
        <v-select
          v-model="exportFormDataValue.company"
          label="配送会社"
          class="mr-2 ml-2"
          :items="fulfillmentCompanies"
          item-title="deliveryCompany"
          item-value="value"
        />
        <v-file-input class="mr-2" label="CSVを選択" />
      </v-card-text>
      <v-card-actions>
        <v-spacer />
        <v-btn color="error" variant="text" @click="toggleExportDialog">
          キャンセル
        </v-btn>
        <v-btn color="primary" variant="outlined" :loading="loading" @click="onSubmitExport">
          登録
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>

  <v-card class="mt-4" flat>
    <v-card-title class="d-flex flex-row">
      注文
      <v-spacer />
      <v-btn color="primary" variant="outlined" @click="toggleImportDialog">
        <v-icon start :icon="mdiImport" />
        Import
      </v-btn>
      <v-btn class="ml-4" color="secondary" variant="outlined" @click="toggleExportDialog">
        <v-icon start :icon="mdiExport" />
        Export
      </v-btn>
    </v-card-title>
  </v-card>
</template>
