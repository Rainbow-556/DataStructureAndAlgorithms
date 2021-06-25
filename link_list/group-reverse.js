import { createLinkList, logLinkList } from './util.js'

const head = createLinkList({ startValue: 1, interval: 1, length: 12 })
logLinkList('source', head)
/**
 * 按groupCount分组翻转链表
 * @param {*} head 
 * @param {*} groupCount 分组的个数
 * @returns 
 */
function groupReverse(head, groupCount) {
  // 1 2 3 4 5 6 7 8 9 -> 3 2 1 6 5 4 9 8 7
  let pre, curr = head, preGroupTail, count = 1, newHead
  while (curr) {
    let next = curr.next
    curr.next = pre
    pre = curr
    curr = next
    // if (count === groupCount) {
    //   // 第一组处理完毕
    //   console.log('first', pre.data);
    //   newHead = pre
    //   // 找到tail
    //   let tail = pre, loopCount = 0
    //   while (loopCount < groupCount - 1) {
    //     tail = tail.next
    //     loopCount++
    //   }
    //   preGroupTail = tail
    //   console.log('first tail', preGroupTail.data);
    // } else 
    if (count % groupCount === 0) {
      // 后续的组处理完毕
      console.log('group tail', pre.data);
      if (preGroupTail) {
        // 上一组的尾元素与下一组的首元素建立连接
        preGroupTail.next = pre
      } else {
        // 第一组处理完毕
        newHead = pre
      }
      // 找到tail
      let tail = pre, loopCount = 0
      while (loopCount < groupCount - 1) {
        tail = tail.next
        loopCount++
      }
      preGroupTail = tail
      console.log('other tail', preGroupTail.data);
    }
    count++
  }
  // 把最后一组的尾节点的next置空，否则就形成环了
  preGroupTail.next = null
  // return pre
  return newHead
}

const result = groupReverse(head, 2)
logLinkList('groupReverse', result)