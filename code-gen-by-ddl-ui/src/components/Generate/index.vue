<template>
  <div>
    <el-form :model="form" label-width="auto" style="max-width: 90%">
      <el-form-item label="包名" :rules="[{ required: true, message: '请输入包名', trigger: 'blur' }]">
        <el-input v-model="form.packageName" placeholder="请输入包名"></el-input>
      </el-form-item>
      <el-form-item label="作者" :rules="[{ required: true, message: '请输入作者', trigger: 'blur' }]">
        <el-input v-model="form.author" placeholder="请输入作者"></el-input>
      </el-form-item>
      <el-form-item label="模块名" :rules="[{ required: true, message: '请输入模块名', trigger: 'blur' }]">
        <el-input v-model="form.moduleName" placeholder="请输入模块名"></el-input>
      </el-form-item>
      <el-form-item label="表前缀">
        <el-input v-model="form.tablePrefix" placeholder="请输入表前缀"></el-input>
      </el-form-item>
      <el-form-item label="DDL" :rules="[{ required: true, message: '请输入模板名称', trigger: 'blur' }]">
        <el-input style="width: 80%;" :rows="25" type="textarea" v-model="form.ddlSql" :placeholder="example"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="generate">生成</el-button>
      </el-form-item>
    </el-form>
    <Result ref="result" :template="response.data"/>
  </div>
</template>

<script setup lang="ts" name="Generate">
import {ref, reactive} from 'vue'
import axios from "axios";
import Result from '../Result/index.vue'
import {type Template} from "@/types/template";
import {type Response} from "@/types/Response";

let result = ref()
const form = reactive({
  ddlSql: '',
  packageName: '',
  author: '',
  moduleName: '',
  tablePrefix: '',
  templateName: 'mybatis-plus'
})
const response = reactive<Response<Template>>({})

const generate = () => {
  // 生成代码
  axios.post("http://localhost:9000/code-gen-api/code-gen", form).then((res) => {
    response.data = res.data.data
    console.log('response.data', response.data)
    console.log(res.data)
    result.value.isShow = true
  })
}

let example = `CREATE TABLE \`t_user\` (
  \`id\` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  \`username\` varchar(30) NOT NULL COMMENT '用户名',
  \`password\` varchar(30) NOT NULL COMMENT '密码',
  \`nickname\` varchar(30) DEFAULT NULL COMMENT '昵称',
  \`email\` varchar(50) DEFAULT NULL COMMENT '邮箱',
  \`phone\` varchar(11) DEFAULT NULL COMMENT '手机号',
  \`status\` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态（0：禁用 1：正常）',
  \`create_time\` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  \`update_time\` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (\`id\`),
  UNIQUE KEY \`uk_username\` (\`username\`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
`;

</script>

<style scoped>
/deep/ .el-input {
  width: 30%;
}
</style>
