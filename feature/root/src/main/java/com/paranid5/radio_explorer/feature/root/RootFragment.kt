package com.paranid5.radio_explorer.feature.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.paranid5.radio_explorer.feature.root.databinding.FragmentRootBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFragment : Fragment() {
    private lateinit var binding: FragmentRootBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_root, container, false)
        return binding.root
    }
}
