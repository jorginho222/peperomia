package com.ivanur.peperomia.todoApp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ivanur.peperomia.R
import com.ivanur.peperomia.todoApp.TaskCategory.Business
import com.ivanur.peperomia.todoApp.TaskCategory.Other
import com.ivanur.peperomia.todoApp.TaskCategory.Personal

class TodoAppActivity : AppCompatActivity() {
    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvTasks: RecyclerView
    private lateinit var fabAddTask: FloatingActionButton
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_app)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
        // Si es vertical el linear lay, solo le pasamos el arg de context (this)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                // obteniendo el boton seleccionado
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { category -> category.isSelected }
        //        filter tasks that contains the selected categories
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }

        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}