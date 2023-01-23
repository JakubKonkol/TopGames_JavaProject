package com.example.topgamestools.logs;

import java.util.List;

public interface IFilterLogs {
    List<String> getInfoLogs(List<String> logs);
    List<String> getWarningLogs(List<String> logs);
    List<String> getErrorLogs(List<String> logs);
    List<String> getDebugLogs(List<String> logs);
}
