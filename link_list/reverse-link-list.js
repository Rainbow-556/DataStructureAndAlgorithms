// 翻转链表
import { createLinkList, logLinkList } from './util.js'

const head = createLinkList({ startValue: 1, interval: 1, length: 10 })
logLinkList('head', head)

function reverseLinkList(head) {
  let curr = head, pre
  while (curr) {
    let next = curr.next
    curr.next = pre
    pre = curr
    curr = next
  }
  return pre
}

const newHead = reverseLinkList(head)
logLinkList('reversed', newHead)