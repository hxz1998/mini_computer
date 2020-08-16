package util;

class MessageCenterTest {
    public static void main(String[] args) {
        MessageCenter messageCenter = new MessageCenter();
        new Thread(messageCenter).start();
        messageCenter.addMessage(new Message(null, "标题", "内容", MessageLevel.INFORMATION));
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    messageCenter.addMessage(new Message(null, "标题" + i, "内容", MessageLevel.INFORMATION));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}