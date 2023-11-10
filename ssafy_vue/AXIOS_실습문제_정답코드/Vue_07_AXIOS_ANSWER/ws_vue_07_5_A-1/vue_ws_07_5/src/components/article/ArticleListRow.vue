<template>
  <tr>
    <td>{{ article.articleId }}</td>
    <RouterLink
      :to="{ name: 'article-detail', params: { id: article.articleId } }"
      style="cursor: pointer"
    >
      {{ article.title }}
    </RouterLink>
    <td>{{ article.userName }}</td>
    <td>{{ createdDate }}</td>
    <td>{{ article.viewCnt }}</td>
    <td>{{ article.like }}</td>
  </tr>
</template>

<script setup>
import { toRefs, computed } from 'vue'
import { RouterLink } from 'vue-router'

const props = defineProps({
  article: Object
})

const { article } = toRefs(props)

const createdDate = computed(() => {
  const dateObj = new Date(article.value.createdAt)

  const dateOptions = { year: 'numeric', month: '2-digit', day: '2-digit' }
  const timeOptions = { hour: '2-digit', minute: '2-digit' }

  const formattedDate = dateObj.toLocaleDateString('ko-KR', dateOptions)
  const formattedTime = dateObj.toLocaleTimeString('ko-KR', timeOptions)

  const formattedString = `${formattedDate} ${formattedTime}`
  return formattedString
})
</script>

<style scoped></style>
