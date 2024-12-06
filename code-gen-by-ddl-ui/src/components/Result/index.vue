<template>
  <el-dialog
      v-model="isShow"
      title="生成结果"
      width="90%"
      @Close="isShow = false"
  >
    <el-tabs v-model="activeName" class="demo-tabs">
      <el-tab-pane label="entity" name="first">
        <el-input
            v-model="template.entity"
            style="width: 100%"
            :rows="25"
            type="textarea"
            placeholder="Please input"
        />
      </el-tab-pane>
      <el-tab-pane label="mapper" name="second">
        <el-input
            v-model="template.mapper"
            style="width: 100%"
            :rows="25"
            type="textarea"
            placeholder="Please input"
        />
      </el-tab-pane>
      <el-tab-pane label="mapperXml" name="third">
        <el-input
            v-model="template.mapperXml"
            style="width: 100%"
            :rows="25"
            type="textarea"
            placeholder="Please input"
        />
      </el-tab-pane>
      <el-tab-pane label="service" name="fourth">
        <el-input
            v-model="template.service"
            style="width: 100%"
            :rows="25"
            type="textarea"
            placeholder="Please input"
        />
      </el-tab-pane>
      <el-tab-pane label="serviceImpl" name="fifth">
        <el-input
            v-model="template.serviceImpl"
            style="width: 100%"
            :rows="25"
            type="textarea"
            placeholder="Please input"
        />
      </el-tab-pane>
      <el-tab-pane label="controller" name="sixth">
        <el-input
            v-model="template.controller"
            style="width: 100%"
            :rows="25"
            type="textarea"
            placeholder="Please input"
        />
      </el-tab-pane>
    </el-tabs>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="isShow = false">Cancel</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts" name="Result">
import {ref} from 'vue'

let isShow = ref(false)
const activeName = ref('first')

defineProps(['template'])
defineExpose({isShow})
</script>

<style scoped>

</style>
