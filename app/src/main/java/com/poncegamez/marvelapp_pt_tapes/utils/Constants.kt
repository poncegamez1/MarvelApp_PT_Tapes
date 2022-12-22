package com.poncegamez.marvelapp_pt_tapes.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class Constants {

    companion object {
        const val PUBLIC_API_KEY = "f829cfbd97b8073cb9157313462f2cff"
        const val PRIVATE_API_KEY = "04f84b4faac2851e13007494f34acd8c5bfdf7ef"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

        fun getHash(): String {
            val input = "$timeStamp$PRIVATE_API_KEY$PUBLIC_API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16)
                .padStart(32, '0')
        }
    }
}