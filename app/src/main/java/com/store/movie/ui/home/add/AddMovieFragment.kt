package com.store.movie.ui.home.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.store.movie.R
import com.store.movie.databinding.FragmentAddMovieBinding
import com.store.movie.share.models.Movie
import com.store.movie.ui.home.add.viewModels.AddMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMovieFragment : Fragment() {

    private lateinit var binding: FragmentAddMovieBinding
    private val viewModel: AddMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmButton.setOnClickListener { onConfirmButtonClicked() }

        viewModel.getState().observe(viewLifecycleOwner) { state -> onStateChanged(state) }
    }

    private fun onConfirmButtonClicked() {
        viewModel.addMovie(generateMovie())
    }

    private fun generateMovie(): Movie {
        val movieName = binding.movieName.text.toString()
        val note = binding.note.text.toString()
        val userRate = binding.userRate.text.toString().toInt()

        // TODO get the selected category one it's implemented
        val categoryId = 1L

        return Movie(name = movieName, note = note, userRate = userRate, categoryId = categoryId)
    }

    private fun onStateChanged(state: Boolean) {
        if (state) {
            Toast.makeText(context, getString(R.string.movie_added_successfully), Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        } else {
            Toast.makeText(context, getString(R.string.error_try_again), Toast.LENGTH_SHORT).show()
        }
    }
}