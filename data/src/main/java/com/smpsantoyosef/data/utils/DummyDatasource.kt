package com.smpsantoyosef.data.utils

import com.smpsantoyosef.common.R
import com.smpsantoyosef.entity.Menu
import com.smpsantoyosef.entity.Absent
import com.smpsantoyosef.entity.Note

object DummyDatasource {
    fun generateMenus() = arrayListOf<Menu>(
        Menu("Absensi", R.drawable.ic_absen),
        Menu("Catatan", R.drawable.ic_note),
        Menu("Nilai", R.drawable.ic_nilai),
        Menu("Ujian", R.drawable.ic_ujian),
    )

    fun generateAbsents() = listOf<Absent>(
        Absent(day = "Senin", date = "01-Januari-2023", "Hadir"),
        Absent(day = "Selasa", date = "02-Januari-2023", "Tidak Hadir"),
        Absent(day = "Rabu", date = "03-Januari-2023", "Hadir"),
        Absent(day = "Kamis", date = "04-Januari-2023", "Tidak Hadir"),
        Absent(day = "Jumat", date = "05-Januari-2023", "Hadir"),
    )

    fun generateNotes() = listOf<Note>(
        Note(day = "Senin", date = "01-01-2023", "Terlambat"),
        Note(day = "Selasa", date = "02-01-2023", "Berantam dengan teman sekelas, sampai babak belum"),
        Note(day = "Rabu", date = "03-01-2023", "Ketahuan pacaran dan merokok dikelas"),
        Note(day = "Kamis", date = "04-01-2023", "Bolos sekolah"),
        Note(day = "Jumat", date = "05-01-2023", "Melawan dengan wali kelas"),
        Note(day = "Sabtu", date = "06-01-2023", "Tidak mengerjakan PR dari guru"),
    )
}