package com.example.fragments

import android.os.Parcel
import android.os.Parcelable

data class UserDates(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: Long,
    val userName: String,
    val password: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeLong(phone)
        parcel.writeString(firstName)
        parcel.writeString(userName)
        parcel.writeString(password)
    }

    companion object CREATOR : Parcelable.Creator<UserDates> {
        override fun createFromParcel(parcel: Parcel): UserDates {
            return UserDates(parcel)
        }

        override fun newArray(size: Int): Array<UserDates?> {
            return arrayOfNulls(size)
        }
    }

}
