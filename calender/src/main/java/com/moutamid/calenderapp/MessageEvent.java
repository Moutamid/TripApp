package com.moutamid.calenderapp;

import org.joda.time.LocalDate;

public class MessageEvent {

    public LocalDate mMessage;

    public MessageEvent(LocalDate message) {
        mMessage = message;
    }

    public LocalDate getMessage() {
        return mMessage;
    }
}