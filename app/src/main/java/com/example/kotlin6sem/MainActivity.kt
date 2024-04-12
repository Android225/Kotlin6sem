package com.example.kotlin6sem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fraim)

        val listViewTasks = findViewById<ListView>(R.id.listViewTasks)

        val tasks = ArrayList<Task>()
        tasks.add(Task("zadacha 1", "Описание задачи 1"))
        tasks.add(Task("zadacha 2", "Описание задачи 1"))
        tasks.add(Task("zadacha 3", "Описание задачи 3"))
        tasks.add(Task("zadacha 4", "Описание задачи 3"))
        tasks.add(Task("zadacha 5", "Описание задачи 3"))

        val adapter = TaskAdapter(this, tasks)
        listViewTasks.adapter = adapter


        // Получаем ссылку на текстовое поле для поиска
        val editTextSearch = findViewById<EditText>(R.id.editTextSearch)

// Добавляем обработчик изменения текста для поля поиска
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Не используем
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // При изменении текста вызываем метод для фильтрации задач
                adapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {
                // Не используем
            }
        })

    }
}