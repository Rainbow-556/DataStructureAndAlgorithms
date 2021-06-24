export class LinkNode {
  constructor(data, next, pre) {
    this.data = data
    this.next = next
    this.pre = pre
  }
  toString() {
    return this.data + ''
  }
}

export function logLinkList(mark, node) {
  let result = ''
  while (node) {
    result = result + node.data + ', '
    node = node.next
  }
  result = result.substring(0, result.length - 2)
  console.log('logLinkList', mark, result)
}

export function createLinkList({ startValue = 1, interval = 1, length = 5, twoWay = false, circleIndex = -1 }) {
  let value = startValue
  let pre, head
  let tailNext
  for (let i = 0; i < length; i++) {
    let node = new LinkNode(value, null, pre)
    value += interval
    if (pre) {
      pre.next = node
    } else {
      head = node
    }
    pre = node
    if (circleIndex !== -1) {
      // 保存有环链表的尾结点的next值
      if (circleIndex === i) {
        tailNext = node
      }
      // 建立环连接
      if (i === length - 1) {
        node.next = tailNext
      }
    }
  }
  return head
}
