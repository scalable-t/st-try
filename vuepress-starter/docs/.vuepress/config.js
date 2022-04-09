module.exports = {
  title: '我的文档',
  description: 'asdfasdf',
  themeConfig: {
    sidebar: [
      '/',
      '/internal/',
    ],
    nav: [
      { text: '文档', link: '/' },
      { text: '内部', link: '/internal/' },
      { text: '组件列表', items: [
        { text: '最大努力通知', link: '/language/chinese/' },
        { text: '分布式锁', link: '/language/japanese/' },
        { text: '统一流水号', link: '/language/japanese/' },
      ] },
      { text: '谷歌', link: 'https://google.com' },
    ],
    sidebarDepth: 2,
  }
}
