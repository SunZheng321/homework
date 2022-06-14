package sunzhengzheng;

public class Ai {

//创建回答返回值方法，参数是输入的字符串
    public String answer(String question) {

        String ret = null;//创建一个中间变量字符串用来存结果

        ret = handleCanStart(question);

        if (ret != null) {
            return ret;
        }

        ret = handleAskTail(question);

        if (ret != null) {
            return ret;
        }

        return handleUnknown(question);

    }
//以你会、能、敢之类开头的回答；
    private String handleCanStart(String question) {
        String[] canStart = new String[]{"会", "能", "有", "敢", "在"};
        for (int i = 0; i < canStart.length; i++) {
            if (question.startsWith(canStart[i])) {
                return canStart[i] + "！";
            }
        }
        return null;
    }
//以吗结尾的回答；
    private String handleAskTail(String question) {
        String[] askTail = new String[]{"吗？", "吗?", "吗"};
        for (int i = 0; i < askTail.length; i++) {
            if (question.endsWith(askTail[i])) {
                return question.replace(askTail[i], "！");
            }
        }
        return null;
    }
//不知道的情况就重复问题
    private String handleUnknown(String question) {
        return question + "!";
    }


}
