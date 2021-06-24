/**
 * 检查链表是否有环
 * 思路：
 * 使用快慢指针，慢指针每次只向前走一步，快指针每次向前走两步，如果链表有环，则在经历过若干次循环后，两个指针会相遇（就是当前所指向的引用会相等）；如果无环，则遍历到链表的尾部会自然结束
 */
import { createLinkList, logLinkList } from './util.js'

const normalHead = createLinkList({ startValue: 1, interval: 1, length: 10, circleIndex: -1 })
const circleHead = createLinkList({ startValue: 1, interval: 1, length: 10, circleIndex: 5 })
logLinkList('head', normalHead)

function hasCircle(head) {
  let slow = head,
    fast = head
  while (slow && fast) {
    // slow每次向前走一步
    slow = slow.next
    // 判断fast.next是否有值
    if (fast.next) {
      // fast每次向前走两步
      fast = fast.next.next
    } else {
      // 无值表示链表遍历结束了，无环，则不能形成循环
      break
    }
    // slow和fast相等时，表示有环
    if (slow && slow === fast) {
      return true
    }
  }
  return false
}

const hasCircle1 = hasCircle(normalHead)
const hasCircle2 = hasCircle(circleHead)

console.log('hasCircle', hasCircle1, hasCircle2)
